import React from 'react'
import { Table } from 'semantic-ui-react'
import PropTypes from 'prop-types'

export const MemberRow = props => (
        <Table.Row>
            <Table.Cell>{props.member.primeKey}</Table.Cell>
            <Table.Cell>{props.member.building}</Table.Cell>
            <Table.Cell>{props.member.flatNo}</Table.Cell>
            <Table.Cell>{props.member.memberName}</Table.Cell>
            <Table.Cell>{props.member.mobileNo}</Table.Cell>
            <Table.Cell>{props.member.primaryEmail}</Table.Cell>
        </Table.Row>
)

MemberRow.propTypes = {
    member : PropTypes.object.isRequired,
};