import { Route, Switch } from 'react-router-dom';
import Enderecos from './Enderecos';

import FormCliente from './FormCliente';
import ListCliente from './ListCliente';
import List from './ListCliente';
import './styles.scss';

const Clientes = () => {
  return (
    <Switch>
      <Route path="/admin/clientes" exact>
        <ListCliente />
      </Route>
      <Route path="/admin/clientes/:clienteId" exact>
        <FormCliente />
      </Route>
      <Route path="/admin/clientes/:clienteId/enderecos">
        <Enderecos />
      </Route>
      <Route path="/admin/clientes/:filtro">
        <ListCliente />
      </Route>
    </Switch>
  );
};

export default Clientes;
