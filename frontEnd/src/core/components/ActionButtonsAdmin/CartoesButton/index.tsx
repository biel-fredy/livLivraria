import { Button } from 'react-bootstrap';
import CreditCard from '@material-ui/icons/CreditCard';
import '../styles.scss';

const CartoesButton = () => (
  <Button
    variant="primary"
    className="action-button"
    title="Cartões"
    href="/gerenciar/cartoes"
  >
    <CreditCard />
  </Button>
);

export default CartoesButton;
