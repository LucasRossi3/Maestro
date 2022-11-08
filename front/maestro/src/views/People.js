import React, { useEffect, useState } from 'react'
import './People.css'
import  {
          Container,
          Card,CardBody,CardTitle,
          Row,
          Col,
        } from 'reactstrap'
import PersonDetail from '../components/PersonDetail'

const People = ({children,config}) => {
  const url = config.url.address + ":" + config.url.port
  const [people,setPeople] = useState([]);
  const [name,setName] = useState('');
  const [doc_rg,setDoc_rg] = useState('');
  const [doc_cpf,setDoc_cpf] = useState('');
  const [birthday,setBirthday] = useState('');
  const [email,setEmail] = useState('');
 
    /* RECEBE DADOS */
    useEffect(() =>{
      async function fetchData(){
        let urlPeopleGet = url + "/people"
         const res = await fetch(urlPeopleGet)
        const data = await res.json()
  
        setPeople(data)
      }
      fetchData()
  
    },[])

  return (
    <>
      
      <Container>
        <Card>
          <CardTitle className='CardTitle' tag={"h1"}>
            Dados dos moradores
          </CardTitle>
          <CardBody>
            <PersonDetail people={people}/>
          </CardBody>
        </Card>
        
      </Container>
    </>
    )
}

export default People