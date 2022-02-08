import { ReactComponent as BookImage } from 'core/assets/images/capas/book.svg';
import ButtonAddCarrinho from 'core/components/ButtonAddCarrinho';
import ProductPrice from 'core/components/ProductPrice';
import { Livro } from 'core/types/livro';
import { Link } from 'react-router-dom';
import './styles.scss';

type Props = {
  livro: Livro;
};

const ProductCard = ({ livro }: Props) => {
  return (
    <div className="card-base border-radius-10 product-card">
      <BookImage />
      <div className="product-info">
        <Link to="/livros/{livro.id}">
          <h6 className="product-name">{livro.nome}</h6>
        </Link>
        <ProductPrice price={livro.preco} />
        <ButtonAddCarrinho />
      </div>
    </div>
  );
};

export default ProductCard;
