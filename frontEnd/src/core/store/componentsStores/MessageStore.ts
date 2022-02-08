import { action, makeAutoObservable } from 'mobx';

interface Message {
  type?: 'success' | 'error' | 'info' | 'warning';
  text: string;
  key: string | number;
}

export class MessageStore {
  messages: Message[];

  constructor() {
    makeAutoObservable(this);
    this.messages = [];
  }

  @action
  setMessage = (
    text: string,
    type?: 'success' | 'error' | 'info' | 'warning',
    key?: string | number
  ) => {
    const newKey = key ? key : Date.now();
    this.messages = this.messages.concat({ text, type, key: newKey });
    setTimeout(() => {
      this.removeMessage(newKey);
    }, 5000);
  };

  @action
  removeMessage = (key: string | number) => {
    this.messages = this.messages.filter((message) => message.key !== key);
  };

  @action
  clean = () => {
    this.messages = [];
  };
}
