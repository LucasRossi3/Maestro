import {React, useState} from 'react'
import {Modal, Button, Table, Container} from 'reactstrap';

const PersonDetail = ({children,people,config}) => {

  const [show, setShow] = useState(false);

  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);

  const [name,setName] = useState('');
  const [doc_rg,setDoc_rg] = useState('');
  const [doc_cpf,setDoc_cpf] = useState('');
  const [birthday,setBirthday] = useState('');
  const [email,setEmail] = useState('');
  
  function handleSubmit (e){
    e.preventDefault()

    const person = {
      name,
      doc_rg,
      doc_cpf,
      email,
    }
  }


  return (
    <Container>
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
                            <td key={i}><Button variant='warning'>Editar</Button><Button variant='danger'>Apagar</Button></td>
                        </tr>
                    ))
                }
            </tbody>
        </Table>
    </Container>
  )
}

export default PersonDetail