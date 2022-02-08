import { Button } from 'react-bootstrap';
import House from '@material-ui/icons/House';
import '../styles.scss';
import { Link, useParams } from 'react-router-dom';


const EnderecosButton = () => {

  const clienteId = useParams()
  return ( 
        <Button variant="primary" className="action-button" title="Endereços">
          <House />
        </Button>    
  );
};

export default EnderecosButton;
