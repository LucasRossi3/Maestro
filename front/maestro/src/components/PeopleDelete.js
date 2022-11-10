import React, {  useEffect, useState } from 'react'
import { 
          Button,
          Table,
          Container,
          Card,
          CardBody,
          CardTitle,
} from 'reactstrap';

const PeopleDelete = ({children,config}) => {
  const url = config.url.address + ":" + config.url.port
  const [people,setPeople] = useState(null);
  const [personId,setPersonId] = useState(null);
  const [id,setId] = useState('');
  const [name,setName] = useState('');    
  const [doc_rg,setDoc_rg] = useState('');
  const [doc_cpf,setDoc_cpf] = useState('');
  const [birthday,setBirthday] = useState('');
  const [email,setEmail] = useState('');
  

    /* RECEBE DADOS */
    let urlPeopleGet = url + "/people";
    const urlPeopleDelete = url + "/person/";
    let urlPersonDelete = urlPeopleDelete;
    
    useEffect(()=>{
      const httpRequest = async ()=>{
        const response = await fetch(urlPeopleGet);

        const json = await response.json();

        setPeople(json);
      };

        httpRequest();
    },[people, personId])

    /* APAGA PESSOA */
    function DeletePerson(id) {
      setPersonId(id);
    }

    useEffect(()=>{
      const httpRequest = async ()=>{
        const response = await fetch(urlPersonDelete+personId,{
                                                          method:"DELETE",
                                                          headers: {"Content-type" : "apllication/json"},
                                                        });
        };
       
        if (personId)
        {
          console.log(personId)
          httpRequest();
          setPersonId(null);
        }
    },[personId])
      
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
                                <td onClick={() => DeletePerson(p.id)}><Button color='danger'>Apagar</Button></td>
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

export default PeopleDelete