import React, { useEffect, useState } from 'react'
import { 
          Button,
          Table,
          Container,
          Card,
          CardBody,
          CardTitle,
} from 'reactstrap';

const PeopleList = ({children,config}) => {
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
          <Table className='table table-striped'>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        people.map((p,i)=> (
                            <tr key={i}>
                                <td key={i}>{p.name}</td>
                                <td>
                                  
                                </td>
                                {/*<td key={i}><Button color='warning' className='mx-1'>Editar</Button><Button color='danger'>Apagar</Button></td>*/}
                            </tr>
                        ))
                    }
                </tbody>
            </Table>
          </CardBody>
        </Card>
        
      </Container>
    </>
    )
}

export default PeopleList