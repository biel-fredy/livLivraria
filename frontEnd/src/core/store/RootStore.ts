import { CatalogoStore } from './componentsStores/CatalogoStore';
import { MessageStore } from './componentsStores/MessageStore';

export class RootStore {
  messageStore = new MessageStore();
  catalogoStore = new CatalogoStore();
}
