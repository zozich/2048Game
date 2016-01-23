import java.util.*;

public enum Move {
    UP {
        @Override
        public List<List<Cell>> makeMove(List<List<Cell>> field) {
            for (int i = 0; i < field.size(); i++) {
                Deque<Cell> queue = new LinkedList();
                for (int j = 0; j < field.size(); j++) {
                    Cell currentCell = field.get(j).get(i);
                    if (!currentCell.isEmpty()) {
                        if (!queue.isEmpty()) {
                            if (queue.peekLast().getValue() == currentCell.getValue()) {
                                queue.peekLast().setValue(queue.peekLast().getValue() * 2);
                            } else {
                                queue.add(new Cell(currentCell.getValue()));
                            }
                        } else {
                            queue.add(new Cell(currentCell.getValue()));
                        }
                    }
                    currentCell.setValue(null);
                }
                for (int j = 0; j < field.size(); j++) {
                    if (!queue.isEmpty()) {
                        field.get(j).get(i).setValue(queue.pollFirst().getValue());
                    } else {
                        break;
                    }
                }
            }
            return field;
        }
    },
    DOWN {
        @Override
        public List<List<Cell>> makeMove(List<List<Cell>> field) {
            for (int i = 0; i < field.size(); i++) {
                Deque<Cell> queue = new LinkedList();
                for (int j = 0; j < field.size(); j++) {
                    Cell currentCell = field.get(j).get(i);
                    if (!currentCell.isEmpty()) {
                        if (!queue.isEmpty()) {
                            if (queue.peekLast().getValue() == currentCell.getValue()) {
                                queue.peekLast().setValue(queue.peekLast().getValue() * 2);
                            } else {
                                queue.add(new Cell(currentCell.getValue()));
                            }
                        } else {
                            queue.add(new Cell(currentCell.getValue()));
                        }
                    }
                    currentCell.setValue(null);
                }
                for (int j = field.size() - 1; j >= 0 ; j--) {
                    if (!queue.isEmpty()) {
                        field.get(j).get(i).setValue(queue.pollFirst().getValue());
                    } else {
                        break;
                    }
                }
            }
            return field;
        }
    },
    LEFT {
        @Override
        public List<List<Cell>> makeMove(List<List<Cell>> field) {
            for (int i = 0; i < field.size(); i++) {
                Iterator<Cell> iterator = field.get(i).iterator();
                Deque<Cell> queue = new LinkedList();
                while (iterator.hasNext()) {
                    Cell currentCell = iterator.next();
                    if (!currentCell.isEmpty()) {
                        if (!queue.isEmpty()) {
                            if (queue.peekLast().getValue() == currentCell.getValue()) {
                                queue.peekLast().setValue(queue.peekLast().getValue() * 2);
                            } else {
                                queue.add(currentCell);
                            }
                        } else {
                            queue.add(currentCell);
                        }
                    }
                    iterator.remove();
                }
                for (int j = 0; j < field.size(); j++) {
                    if (!queue.isEmpty()) {
                        field.get(i).add(queue.pollFirst());
                    } else {
                        field.get(i).add(new Cell());
                    }

                }
            }
            return field;
        }
    },
    RIGHT {
        @Override
        public List<List<Cell>> makeMove(List<List<Cell>> field) {
            for (int i = 0; i < field.size(); i++) {
                Iterator<Cell> iterator = field.get(i).iterator();
                Deque<Cell> queue = new LinkedList();
                while (iterator.hasNext()) {
                    Cell currentCell = iterator.next();
                    if (!currentCell.isEmpty()) {
                        if (!queue.isEmpty()) {
                            if (queue.peekLast().getValue() == currentCell.getValue()) {
                                queue.peekLast().setValue(queue.peekLast().getValue() * 2);
                            } else {
                                queue.add(currentCell);
                            }
                        } else {
                            queue.add(currentCell);
                        }
                    }
                    iterator.remove();
                }
                for (int j = field.size() - 1; j >= 0; j--) {
                    if (!queue.isEmpty()) {
                        field.get(i).add(queue.pollFirst());
                    } else {
                        field.get(i).add(0, new Cell());
                    }

                }
            }
            return field;
        }
    };

    public abstract List<List<Cell>> makeMove(List<List<Cell>> field);

}
