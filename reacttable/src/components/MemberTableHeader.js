import React from 'react'
import { Table} from 'semantic-ui-react'

export default function MemberTableHeader(props) {

    return (
            <Table.Header>
                <Table.Row>
                <Table.HeaderCell 
                        width={2}
                        sorted={props.column ==="primeKey" ? props.direction : null }    
                        onClick = {() => props.handleSort("primeKey")} 
                    >
                    Primary Key 
                    </Table.HeaderCell>                 
                    <Table.HeaderCell 
                        width={2}
                        sorted={props.column ==="building" ? props.direction : null }    
                        onClick = {() => props.handleSort("building")} 
                    >
                    Building
                    </Table.HeaderCell>      
                    <Table.HeaderCell 
                        width={3}
                        sorted={props.column ==="flatNo" ? props.direction : null }    
                        onClick = {() => props.handleSort("flatNo")} 
                    >
                    Flat No
                    </Table.HeaderCell>                 
                    <Table.HeaderCell 
                        width={10}
                        sorted={props.column ==="memberName" ? props.direction : null }    
                        onClick = {() => props.handleSort("memberName")} 
                    >
                    Member Name
                    </Table.HeaderCell>    
                    <Table.HeaderCell 
                        width={10}
                        sorted={props.column ==="mobileNo" ? props.direction : null }    
                        onClick = {() => props.handleSort("mobileNo")} 
                    >
                    Mobile No
                    </Table.HeaderCell>      
                    <Table.HeaderCell 
                        width={10}
                        sorted={props.column ==="primaryEmail" ? props.direction : null }    
                        onClick = {() => props.handleSort("primaryEmail")} 
                    >
                    Primary Email
                    </Table.HeaderCell>
                </Table.Row>  
            </Table.Header>
    )
}

