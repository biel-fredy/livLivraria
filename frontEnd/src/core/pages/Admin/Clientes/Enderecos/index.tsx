import { Route, Switch } from 'react-router-dom';
import Form from './Form';
import ListEndereco from './ListEndereco';

import List from './ListEndereco';
import NovoEndereco from './NovoEndereco';

const Enderecos = () => {
  return (
    <Switch>
      <Route path="/admin/clientes/:clienteId/enderecos" exact>
        <ListEndereco />
      </Route>
      <Route path="/admin/clientes/:clienteId/enderecos/:enderecoId">
        <NovoEndereco />
      </Route>
    </Switch>
  );
};

export default Enderecos;
