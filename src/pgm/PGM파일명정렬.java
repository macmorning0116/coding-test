package pgm;

import java.util.*;

class PGM파일명정렬 {
    public String[] solution(String[] files) {
        List<FileInfo> list = new ArrayList<>();
        String[] answer = new String[files.length];



        for(String str: files){
            StringBuilder fileHead = new StringBuilder();
            StringBuilder fileNum = new StringBuilder();

            boolean head = true;
            boolean number = true;

            for(char c: str.toCharArray()){
                if(head){
                    if(!(c >= '0' && '9' >= c)){
                        fileHead.append(c);
                    }else{
                        head = false;
                        if(c >= '0' && '9' >= c) fileNum.append(c);
                    }
                }else if(number){
                    if(c >= '0' && '9' >= c) fileNum.append(c);
                    else number = false;
                }
            }

            // System.out.println(fileHead);
            // System.out.println(fileNum);
            list.add(new FileInfo(str, fileHead.toString(), Integer.parseInt(fileNum.toString())));
        }


        list.sort((o1,o2) -> {
            int headCompare = o1.fileHead.toLowerCase().compareTo(o2.fileHead.toLowerCase());
            if(headCompare != 0) return headCompare;

            return o1.fileNumber - o2.fileNumber;
        });

        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i).fileName;
        }


        return answer;
    }
    class FileInfo {
        String fileName;
        String fileHead;
        int fileNumber;

        public FileInfo(String fileName, String fileHead, int fileNumber) {
            this.fileName = fileName;
            this.fileHead = fileHead;
            this.fileNumber = fileNumber;
        }

        public String toString() {
            return fileName;
        }
    }
}