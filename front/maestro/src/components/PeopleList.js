import React, { useState } from 'react'
import { useCrud } from '../hooks/useCrud';

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
  const [name,setName] = useState('');
  const [doc_rg,setDoc_rg] = useState('');
  const [doc_cpf,setDoc_cpf] = useState('');
  const [birthday,setBirthday] = useState('');
  const [email,setEmail] = useState('');
 
  /* RECEBE DADOS */
  let urlPeopleGet = url + "/people";
  const { data: people } = useCrud(urlPeopleGet);

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
                        people && people.map((p,i)=> (
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