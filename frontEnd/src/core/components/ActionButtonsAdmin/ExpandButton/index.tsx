import { Button } from 'react-bootstrap';
import ExpandMore from '@material-ui/icons/ExpandMore';
import '../styles.scss';
import { Link, useParams } from 'react-router-dom';

const ExpandButton = () => {
  return (
    <Button variant="primary" title="Expandir" size="sm">
      <ExpandMore />
    </Button>
  );
};

export default ExpandButton;
