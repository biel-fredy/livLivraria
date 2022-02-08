import { Button } from 'react-bootstrap';
import DeleteIcon from '@material-ui/icons/Delete';
import '../styles.scss';

const DeleteButton = () => (
  <Button variant="danger" className="action-button" title="Excluir">
    <DeleteIcon />
  </Button>
);

export default DeleteButton;
