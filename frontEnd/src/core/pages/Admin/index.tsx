import { Switch, Route } from 'react-router-dom';
import Clientes from './Clientes';
import Navbar from './Navbar';

import './styles.scss';
import Livros from './Livros';
import Bandeiras from './Bandeiras';

const Admin = () => {
  return (
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <Route path="/admin/livros">
            <Livros />
          </Route>
          <Route path="/admin/clientes">
            <Clientes />
          </Route>
          <Route path="/admin/bandeiras">
            <Bandeiras />
          </Route>
        </Switch>
      </div>
    </div>
  );
};
export default Admin;
