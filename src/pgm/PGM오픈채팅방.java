package pgm;

import java.util.*;

class PGM오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};
        List<String> list = new ArrayList<>();
        Map<String, String> nickname = new HashMap<>();

        for(String rec: record){
            String[] info = rec.split(" ");

            // System.out.println(Arrays.toString(info));

            String status = info[0];
            String id = info[1];
            String name = "";

            if(!status.equals("Leave")){
                name = info[2];
            }

            if(status.equals("Enter") || status.equals("Change")){
                nickname.put(id, name);
            }
        }

        for(String rec: record){
            String[] info = rec.split(" ");
            String status = info[0];
            String id = info[1];

            if(status.equals("Enter")){
                list.add(nickname.get(id) + "님이 들어왔습니다.");
            }else if(status.equals("Leave")){
                list.add(nickname.get(id) + "님이 나갔습니다.");
            }
        }

        answer = new String[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}