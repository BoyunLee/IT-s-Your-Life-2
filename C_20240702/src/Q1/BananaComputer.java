package Q1;

class BananaComputer implements Computer {
    @Override
    public void start() {
        System.out.println("바나나컴퓨터----------------");
        System.out.println("바나나컴퓨터가 시작되었습니다.");
    }

    @Override
    public void shutdown() {
        System.out.println("바나나 컴퓨터는 3시간 이후에 전원이 꺼집니다.");
    }

    @Override
    public void restart() {
        System.out.println("바나나 컴퓨터는 왼쪽 아래에 아이콘을 누르면 재시작합니다.");
    }
}

