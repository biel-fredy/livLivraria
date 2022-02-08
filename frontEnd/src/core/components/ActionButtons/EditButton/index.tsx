import { Button } from 'react-bootstrap';
import EditIcon from '@material-ui/icons/Edit';
import '../styles.scss';

const EditButton = () => (
  <Button variant="warning" className="action-button" title="Editar">
    <EditIcon />
  </Button>
);

export default EditButton;
