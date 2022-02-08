import ProductCard from './components/ProductCard';
import AccessAlarmIcon from '@material-ui/icons/AccessAlarm';
import './styles.css';
import { Livro } from 'core/types/livro';
import { Link } from 'react-router-dom';

const Catalogo = () => {
  const livro: Livro = {
    id: 1,
    preco: 22,
    nome: 'Guia dos Mochileiros',
  };

  return (
    <div className="catalog-container">
      <h1 className="catalog-title">
        Confira nossos livros <AccessAlarmIcon />
      </h1>
      <div className="catalog-products">
        <Link to="/livros/1">
          <ProductCard livro={livro} />
        </Link>
      </div>
    </div>
  );
};

export default Catalogo;
