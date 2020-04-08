import React from 'react'
import { Dropdown } from 'semantic-ui-react'

const limitOptions = [
    {key : '0', value: '5' , text: '5'},
    {key : '1', value: '10' , text: '10'},
    {key : '2', value: '15' , text: '15'},
    {key : '3', value: '20' , text: '20'}
]

export const MemberPageSizeSelect = props => (
    <React.Fragment>
        <span>
        Records per page: {''}
        <Dropdown    
            inline
            options ={limitOptions}
            defaultValue={props.limit}
            onChange={props.onChangeLimit}
        />
        </span>
    </React.Fragment>


)
