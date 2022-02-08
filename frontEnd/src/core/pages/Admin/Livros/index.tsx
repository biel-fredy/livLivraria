import { Route, Switch } from 'react-router-dom';
import FormLivro from './FormLivro';
import ListLivro from './ListLivro';
import './styles.scss';

const Livros = () => {
  return (
    <Switch>
      <Route path="/admin/livros" exact>
        <ListLivro />
      </Route>
      <Route path="/admin/livros/:clienteId" exact>
        <FormLivro />
      </Route>
    </Switch>
  );
};

export default Livros;
