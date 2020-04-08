import React , { Component } from 'react';
import { Container, Header, Menu } from 'semantic-ui-react';
import './App.css';

import MemberList from './components/MemberList'

class App extends Component {
  render() {
    return (
      <Container style={{ padding: '2em 0em' }}>
        <Menu borderless secondary>
          <Menu.Item>
            <Header>React Semantic UI Sortable Table Example</Header>
          </Menu.Item>
          <Menu.Item position="right">

          </Menu.Item>
        </Menu>

        <MemberList />
      </Container>
    );
  }
}

export default App;