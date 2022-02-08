import { formatPreco } from 'core/utils/formatters';
import './styles.scss';

type Props = {
  price: number;
};

const ProductPrice = ({ price }: Props) => (
  <div className="product-price-container">
    <span className="product-currency">R$</span>
    <h3 className="product-price">{formatPreco(price)}</h3>
  </div>
);

export default ProductPrice;
