import { useEffect, useState } from 'react';
import './App.css';
import Formulario from './Formulario';
import Tabele from './Tabela';

function App() {

const produto = {
  name: '',
  description: '',
}


  const [btnCadastra, setBtnCadastrar] = useState(true);
  const[produtos, setProdutos] = useState([]);
  const [objProduto, setObjProduto] = useState(produto) 


  useEffect(() => {
    fetch("http://localhost:8080/products/listar")
    .then(retorno => retorno.json())
    .then(returno_convertido => setProdutos(returno_convertido))
  }, []);

  const aoDigita = (e) => {
  const { name, value } = e.target;

  if (name === "price") {
    setObjProduto({ ...objProduto, [name]: parseFloat(value) });
  } else if (name === "quantity") {
    setObjProduto({ ...objProduto, [name]: parseInt(value) });
  } else {
    setObjProduto({ ...objProduto, [name]: value });
  }
};


const remover = () => {
  fetch("http://localhost:8080/products/remover", {
    method: 'delete',
    body: JSON.stringify(objProduto),
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    
    }
  })
  .then(retorno => retorno.json())
  .then(retorno_convertido =>  {

    alert(retorno_convertido.menssagem)

    let vetorTemp = [...produtos]

    let indice = vetorTemp.findIndex((p) => {
      return p.codigo === objProduto.codigo;
    });

    vetorTemp.splice(indice, 1)

    setProdutos(vetorTemp )

    limparFormulario();
  })
}


const cadastrar = () => {
  fetch("http://localhost:8080/products/cadastrar", {
    method: 'Post',
    body: JSON.stringify(objProduto),
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    
    }
  })
  .then(retorno => retorno.json())
  .then(retorno_convertido =>  {
    if(retorno_convertido.menssagem !== undefined) {
      alert(retorno_convertido.menssagem);
    } else {
      setProdutos([...produtos, retorno_convertido]);
      alert('ok')
      limparFormulario();
    }
  })
}


const alterar = () => {
  fetch("http://localhost:8080/products/alterar", {
    method: 'put',
    body: JSON.stringify(objProduto),
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    
    }
  })
  .then(retorno => retorno.json())
  .then(retorno_convertido =>  {

    if(retorno_convertido.menssagem !== undefined) {
      alert(retorno_convertido.menssagem);
    } else {

      alert('ok')

       let vetorTemp = [...produtos]

    let indice = vetorTemp.findIndex((p) => {
      return p.codigo === objProduto.codigo;
    });

    vetorTemp[indice] = objProduto

    setProdutos(vetorTemp )

      limparFormulario();
    }
  })
}

const limparFormulario = () => {
  setObjProduto(produto);
  setBtnCadastrar(true);
}


const selecionarProduto = (indece) => {
  setObjProduto(produtos[indece]);
  setBtnCadastrar(false);
}


  return (
    <div>
    <Formulario botao={btnCadastra} eventoTeclado={aoDigita} cadastrar={cadastrar} obj={objProduto} cancelar={limparFormulario} remover={remover} alterar={alterar} />
    <Tabele vetor={produtos} selecionar={selecionarProduto}/>
    </div>
  );
}

export default App;
