import { Link } from 'react-router-dom';
import './styles.scss';
import { ReactComponent as BookImage } from '../../../../assets/images/capas/book.svg';
import ButtonAddCarrinho from '../../../../components/ButtonAddCarrinho';
import ProductPrice from '../../../../components/ProductPrice';
import { Livro } from 'core/types/livro';

type Props = {
  livro: number;
};

const DetalhamentoProduto = ({ livro }: Props) => {
  return (
    <div className="product-details-container">
      <div className="card-base border-radius-20 product-details">
        <Link to="/livros" className="product-details-goback">
          <h1 className="product-details-goback-text">Voltar</h1>
        </Link>
        <div className="row">
          <div className="col-6 pr-5">
            <div className="product-details-card text-center">
              <BookImage className="product-details-image" />
            </div>

            <div className="product-details-name">Livro 1</div>

            <ProductPrice price={30} />

            <div>
              <ButtonAddCarrinho />
            </div>
          </div>
          <div className="col-6 product-details-card">
            <h1 className="product-description-title">Detalhes do Livro</h1>
            <p className="product-description-text">
              TESTESTESTESTSESESSDOJDOSJOADJAOSDPASJDOA
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default DetalhamentoProduto;
