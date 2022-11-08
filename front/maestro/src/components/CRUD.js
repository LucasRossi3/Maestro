import {React, useState} from 'react'
import { Button, Table, Container} from 'reactstrap';
import People from '../views/People';
import PeopleDelete from './PeopleDelete';
import PeopleList from './PeopleList';

const CRUD = ({children,config}) => {
  return (
    <>
        <h1> Seção CREATE</h1>
        
        <h1> Seção READ</h1>
        <PeopleList config={config} />
        <h1> Seção UPDATE</h1>

        <h1> Seção DELETE</h1>
        <PeopleDelete config={config} />
    </>

  )
}

export default CRUD