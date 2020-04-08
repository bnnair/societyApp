import React from 'react';
import PropTypes from 'prop-types';
import { Table, Pagination } from 'semantic-ui-react';

import { MemberPageSizeSelect } from './MemberPageSizeSelect';
import { MemberRow } from './MemberRow';
import  MemberTableHeader from './MemberTableHeader';


export const MemberTable = props => {

    if (!props.members) {
      return <React.Fragment />
    }
    const Rows = props.members.map((member, index) => (
        <MemberRow key={index} member={member}  />
      ))
      console.log("inside MT----------"+props.currentPage)
      return (
        
        <React.Fragment>
          <MemberPageSizeSelect  
            limit={props.limit}
            onChangeLimit={props.onChangeLimit}
          />
          Total count: {props.totalCount}.
          <Table celled selectable sortable>
            <MemberTableHeader
              column={props.column}
              direction={props.direction}
              handleSort={props.handleSort}
            />
    
            <Table.Body>{Rows}</Table.Body>
    
            <Table.Footer>
              <Table.Row>
                <Table.HeaderCell colSpan="8">
                  <Pagination
                    totalPages={props.totalPages}
                    activePage={props.currentPage}
                    onPageChange={props.onChangePage}
                  />
                </Table.HeaderCell>
              </Table.Row>
            </Table.Footer>
          </Table>
        </React.Fragment>
      );
    };
    
    MemberTable.propTypes = {
      totalCount: PropTypes.number.isRequired,
      totalPages: PropTypes.number.isRequired,
      currentPage: PropTypes.number.isRequired,
      onChangePage: PropTypes.func.isRequired,
      onChangeLimit: PropTypes.func.isRequired,
      limit: PropTypes.string.isRequired,
    }