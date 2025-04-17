package pgm;

import java.util.*;

class PGM이모티콘할인행사 {
    List<List<Emo>> emoList;
    int[] r = {10,20,30,40};

    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int money = 0;
        int member = 0;

        emoList = new ArrayList<>();

        makeEmo(emoticons, 0, new ArrayList<>());

        for(int i = 0; i < emoList.size(); i++){
            List<Emo> temp = emoList.get(i);
            int totalPrice = 0;
            int totalMember = 0;
            for(int j = 0; j < users.length; j++){
                int[] user = users[j];
                int price = 0;
                for(Emo e: temp){
                    if(e.saleRatio >= user[0]) price += e.salePrice;
                }
                if(price >= user[1]) totalMember++;
                else totalPrice += price;
            }

            if(totalMember > member){
                member = totalMember;
                money = totalPrice;
            }else if(member == totalMember){
                if(totalPrice > money) money = totalPrice;
            }

        }

        answer[0] = member;
        answer[1] = money;

        return answer;
    }

    private void makeEmo(int[] emoticons, int n, List<Emo> temp){
        if(n == emoticons.length){
            emoList.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < r.length; i++){
            temp.add(new Emo(emoticons[n], getSalePrice(emoticons[n], r[i]), r[i]));
            makeEmo(emoticons, n+1, temp);
            temp.remove(temp.size() - 1);
        }
    }

    private int getSalePrice(int price, int ratio){
        double result = price * ((100 - ratio) * (0.01));
        return (int) result;
    }


    class Emo {
        int originPrice;
        int salePrice;
        int saleRatio;

        public Emo(int origin, int salePrice, int ratio){
            this.originPrice = origin;
            this.salePrice = salePrice;
            this.saleRatio = ratio;
        }

        public String toString(){
            return "[oriPrice = " + originPrice + " salePrice = " + salePrice + " saleRatio = " + saleRatio + "]";
        }
    }

}
