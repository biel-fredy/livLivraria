export type SpringPage<T> = {
  content: T[];
  last: boolean;
  totalElements: number;
  totalPages: number;
  size: number;
  number: number;
  firt: boolean;
  numberOfElemnts?: number;
  empty: boolean;
};
