import './App.css';
// Importing the Bootstrap CSS
import 'bootstrap/dist/css/bootstrap.min.css';
import CRUD from './components/CRUD';

function App() {
  const config =  {
    "tb_person":{
      "active" :true,
      "name": {"active" : true, "required": "yes", "label":"Nome"},
      "doc_rg": {"active" : false, "required": "yes", "label":"RG"},
      "doc_cpf": {"active" : false, "required": "yes", "label":"CPF"},
      "birthday": {"active" : false, "required": "yes", "label":"Data Nascimento"},
      "email": {"active" : false, "required": "yes", "label":"E-mail"},

    },
    "tb_unit": {
      "unit": {"active" : true, "required": "yes", "label":"Unidade"},
      "block": {"active" : true, "required": "yes", "label":"Bloco"},
      "square": {"active" : false, "required": "yes", "label":"Quadra"},
      "lot" : {"active" : false, "required": "yes", "label":"Lote"},
      "intercom": {"active" : true, "required": "yes", "label":"Interfone"},
      "active":true,
    },
    "url": {
      "address": "http://10.0.1.215",
      "port": 8080
    }
}
  return (
    <>
      <CRUD config={config}/>
    </>
  );
}

export default App;
