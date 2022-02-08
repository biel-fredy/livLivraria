import { Route, Switch } from 'react-router-dom';
import FormBandeira from './FormBandeira';
import ListBandeira from './ListBandeira';
import './styles.scss';

const Bandeiras = () => {
  return (
    <Switch>
      <Route path="/admin/bandeiras" exact>
        <ListBandeira />
      </Route>
      <Route path="/admin/bandeiras/:bandeiraId" exact>
        <FormBandeira />
      </Route>
    </Switch>
  );
};

export default Bandeiras;
