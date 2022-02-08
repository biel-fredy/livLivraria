import CadastroCartao from 'core/components/Cadastros/CadastroCartao';
import Cartoes from 'core/pages/Cartoes';
import Documentos from 'core/pages/Documentos';
import Enderecos from 'core/pages/Enderecos';
import Home from 'core/pages/Home';
import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import CadastroCliente from './core/components/Cadastros/CadastroCliente';
import Header from './core/components/Header';
import Admin from './core/pages/Admin';
import Catalog from './core/pages/Catalog';
import DetalhamentoProduto from './core/pages/Catalog/components/DetalhamentoProduto';

function Routes() {
  return (
    <BrowserRouter>
      <Header />
      <Switch>
        <Route path="/" component={Home} exact />
        <Route path="/cadastrar/cliente" component={CadastroCliente} />
        <Route path="/alterar/cliente/:idCliente" component={CadastroCliente} />
        <Route path="/livros" component={Catalog} exact />
        <Route path="/livros/:livroId" component={DetalhamentoProduto} />
        <Redirect from="/admin" to="/admin/livros" exact /> */
        <Route path="/admin" component={Admin} />
        <Route path="/enderecos" component={Enderecos} />
        <Route path="/gerenciar/documentos" component={Documentos} />
        <Route path="/gerenciar/cartoes" component={Cartoes} />
        <Route path="/alterar/cartoes/:idCartao" component={CadastroCartao} />
      </Switch>
    </BrowserRouter>
  );
}

export default Routes;
