import { Button } from 'react-bootstrap';
import SearchIcon from '@material-ui/icons/Search';
import '../styles.scss';

const SearchButton = () => (
  <Button variant="primary" size="sm" title="Buscar">
    <SearchIcon />
  </Button>
);

export default SearchButton;
