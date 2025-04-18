package pgm;

import java.util.*;

class PGM과제진행하기 {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<Subject> subjects = new ArrayList<>();
        Stack<Subject> stack = new Stack<>();
        for(String[] plan: plans){
            subjects.add(new Subject(plan[0], timeToInt(plan[1]), remainToInt(plan[2])));
        }

        subjects.sort((a, b) -> a.start - b.start);
        int lastTime = (23 * 60) + 59 + 1;

        int idx = 1;
        Subject running = null;
        Subject next = subjects.get(0);
        int i = -1;

        while(true){
            i++;
            if(running == null && next == null) break;

            if(next != null && next.start == i){  // next 시작 시간 됨
                if(running != null){ // 현재 진행중인게 있음
                    running.remain--;
                    if(running.remain <= 0){ // 현재 진행중인거 끝
                        answer.add(running.name); // 이름 넘
                    }else{                  // 아직 남음
                        stack.add(running); // 진행중인거 stack 에 넘
                    }
                    running = next; // next를 진행중으로 바꿈
                    if(idx < subjects.size()) next = subjects.get(idx++);
                    else next = null;
                }else{   // 현재 진행중인거 없음
                    running = next;
                    if(idx < subjects.size()) next = subjects.get(idx++);
                    else next = null;
                }
            }else{        // 아직 다음꺼 시작 시각 아님
                if(running != null){  // 진행중인게 있음
                    running.remain--;
                    if(running.remain <= 0){
                        answer.add(running.name);
                        running = null;
                        if(!stack.isEmpty()) running = stack.pop();
                    }
                }else{  // 진행중인게 없음
                    if(!stack.isEmpty()){
                        running = stack.pop(); // 가장 최근에 멈춘 작업 불러옴
                        running.remain--;
                        if(running.remain <= 0){
                            answer.add(running.name);
                            running = null;
                            if(!stack.isEmpty()) running = stack.pop();
                        }
                    }

                }

            }
        }

        String[] result = new String[answer.size()];
        for(int k = 0; k < answer.size(); k++){
            result[k] = answer.get(k);
        }

        return result;
    }

    // 시각을 int로 환산
    private int timeToInt(String time){
        return (Integer.parseInt(time.substring(0,2)) * 60) + Integer.parseInt(time.substring(3,5));
    }

    // 남는 시각 int로 환산
    private int remainToInt(String time){
        return Integer.parseInt(time);
    }


    class Subject {
        String name;
        int start;
        int remain;

        public Subject(String name, int start, int remain){
            this.name = name;
            this.start = start;
            this.remain = remain;
        }

        public String toString(){
            return name + ", " + start + ", " + remain;
        }
    }
}
