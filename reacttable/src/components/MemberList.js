import React from 'react';
import { Divider, Segment } from 'semantic-ui-react';
import debounce from 'lodash.debounce';
import { MemberTable } from './MemberTable';
import { MemberFilter } from './MemberFilter';

const queryParams = ['_limit', '_order', '_sort', 'q', '_page'];

export default class MemberList extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      members: [],
      _sort: 'building',
      _page: 1,
      _order: 'asc',
      _limit: 5,
      q: '',
      totalCount: 0,
      loading: false,
      
    };

    
    this.onSubmitFilter = debounce(this.onSubmitFilter, 800);
  }

  componentDidMount() {
     this.loadData({});
  }

  static directionConverter(order) {
    if (order === 'asc') {
      return 'ascending';
    } else if (order === 'desc') {
      return 'descending';
    } else {
      return null;
    }
  }

  handleSort = clickedColumn => {
    const { _sort, _order } = this.state;

    let newOrder = _order === 'asc' ? 'desc' : 'asc';
    if (_sort !== clickedColumn) {
      newOrder = 'asc';
    }

    this.loadData({
      
      _sort: clickedColumn,
      _page: 1,
      _order: newOrder,

    });
  };

  onChangeLimit = (event, data) => {
    if (data.value !== this.state._limit) {
      this.loadData({ _limit: data.value, _page: 1});
    }
  };

  onSubmitFilter = filter => {
    if (filter !== this.state.q) {
      this.loadData({ q: filter, _page: 1 });
    }
  };

  onChangePage = (event, data) => {
    const { activePage } = data;
    if (activePage !== this.state._page) {
      console.log("-------------"+ activePage +"----------"+this.state._page);
      this.loadData({ _page: activePage });
    }
  };


  loadData = params => {
    const newState = Object.assign({}, this.state, params, { loading: false });
    this.setState({ loading: true });

    queryParams.forEach(function(element) {
      if (!(element in params)) {
        console.log("element-----"+ element.toString() + "---------"+ newState[element])
        params[element] = newState[element];
      }
    });

    const esc = encodeURIComponent;
    const query = Object.keys(params)
      .map(k => k === '_page' ? esc(k) + '=' + esc(params[k]-1) : esc(k) + '=' + esc(params[k]))
      .join('&');
    console.log("query ----------"+ query)
    // Make a request without limit first to get the total number of data.
    let totalCountQuery = '';
    if (params.q !== '') {
      totalCountQuery = `q=${params.q}`;
    }
    console.log("totalCountQuery-------" + totalCountQuery)

    fetch(`http://localhost:8080/member/allMembers?${totalCountQuery}`).then(response => {
      if (response.ok) {
        response.json().then(data => {
          this.setState({ 
            totalCount: data.length,
      
          });
        });
      } else {
        response.json().then(error => {
          console.log(`Failed to load data: ${error.message}`);
        });
      }
      this.setState(newState, () => {
        fetch('http://localhost:8080/member/allMembersWithParams?' + query).then(response => {
          if (response.ok) {
            response.json().then(data => {
              this.setState({ members: data });
            });
          } else {
            response.json().then(error => {
              console.log(`Failed to load data: ${error.message}`);
            });
          }
          const newState = Object.assign({}, this.state, params, {
            loading: false,
          });
          this.setState(newState);
        });
      });
    });
  };

  render() {
    return (
      <Segment>
        <MemberFilter
          filter={this.state.q}
          totalCount={this.state.totalCount}
          onSubmitFilter={this.onSubmitFilter}
          loading={this.state.loading}
        />
        <Divider />
        <MemberTable
          members={this.state.members}
          totalCount={this.state.totalCount}
          totalPages={Math.ceil(this.state.totalCount / this.state._limit)}
          currentPage={this.state._page}
          onChangePage={this.onChangePage}
          column={this.state._sort}
          direction={MemberList.directionConverter(this.state._order)}
          handleSort={this.handleSort}
          onChangeLimit={this.onChangeLimit}
          limit={this.state._limit.toString()}
        />
      </Segment>
    );
  }
}