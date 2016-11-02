/*
Date:2016/11/02
author:Eiko Hoshino
What:AI同士の対戦を実現させるクラス
*/

public class AIvsAI
{
	public AI ai=new AI();
	public AI ai2=new AI();
	public MainPanel MainPanel =new MainPanel();

    private Counter counter=new Counter();
    public static void competition(String args[])
    {

	int num=0;game=1;
	int i=0;
	int black=0,white=0,draw=0;//それぞれの勝ち数と引き分けの数
	for(game=1;game<=1000;game++){//1000試合の自動対戦
	    switch(MainPanel.gameState){
	    case START:
		System.out.printf("%d戦目%n",game);
		i=0;//現在の手数
		gameState=PLAY;
		break;
	    case PLAY:
		if(game%2==1){
		    System.out.printf("先手:プログラム１%n");
		    System.out.printf("後手:プログラム２%n");
		    while(MainPanel1.endGame()==false){
			if(i % 2 == 0) {
			    System.out.printf("プログラム１%n");
			    ai.compute();
			   
			}
			else{
			    System.out.printf("プログラム２%n");
                ai2.compute();
			}
			i++;	
		    }
            break;
		}
		  else{
		    System.out.printf("先手:プログラム２%n");
		    System.out.printf("後手:プログラム１%n");
		    while(num == 0){
			if(i % 2 == 0) {
			    System.out.printf("プログラム２%n");
			    ai2.compute();
			    if(MainPanel.endGame()==true){
				break;}
			}
			else{
			    System.out.printf("プログラム１%n");
			    ai.compute();
			    if(MainPanel.endGame()==true){
				break;}
			}
			i++;	
		    }
		}
		break;
	    case YOU_WIN:
		black++;
	    case YOU_LOSE:
		white++;
	    case DRAW:
		draw++;
		System.out.printf("戦績：プログラム１%,d勝:プログラム２%d勝：引き分け%d回%n%n",black,white,draw);
		// ゲーム終了時にクリックされたらスターとへ戻る
                gameState = START;
                // 盤面初期化
                initBoard();
                break;
	    }
	    repaint();
	
    

