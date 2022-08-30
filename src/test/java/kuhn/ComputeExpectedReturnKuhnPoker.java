package kuhn;

import org.junit.Test;

public class ComputeExpectedReturnKuhnPoker {

	@Test
	public void calc() {
		// probability of player_A betting with Jack
		// alpha in (0,1/3)
		double alpha = 0.;

		double R=1.d;
		double RJ=1.d/3;
		double RK=1.d/3;
		double RQ=1.d/3;
		double RJK=1.d/2;
		double RJQ=1.d/2;
		double RQJ=1.d/2;
		double RQK=1.d/2;
		double RKJ=1.d/2;
		double RKQ=1.d/2;
		double RK_B=3d*alpha;
		double RJ_B=alpha;
		double RJ_K=1d-alpha;
		double RK_K=1d-3.*alpha;
		double RQ_B=0;
		double RQ_K=0;
		double R_QBF=1d-(1d/3);
		double R_QBC=1d/3;
		double R_KBF=0d;
		double R_JBF=1d;
		double R_KKK=0d;
		double R_JKK=2d/3;
		double R_QKB=0d;
		double R_KKB=1d;
		double R_JKB=1d/3;
		double R_QKK=1d;
		double R_KBC=1d;
		double R_JBC=0d;
		double RQ_KBF=1d-(alpha+1d/3);
		double RQ_KBC=alpha+1d/3;
		double RJ_KBF=1d;
		double RJ_KBC=0d;
		double RK_KBF=0d;
		double RK_KBC=1d;
		
		
		// auto-generated
		double expected_payoff=
				R * RJ * RJQ * RJ_K * R_QKK * (-1)
				+
				R * RJ * RJQ * RJ_K * R_QKB * RJ_KBF * (-1)
				+
				R * RJ * RJQ * RJ_K * R_QKB * RJ_KBC * (-2)
				+
				R * RJ * RJQ * RJ_B * R_QBF * (1)
				+
				R * RJ * RJQ * RJ_B * R_QBC * (-2)
				+
				R * RJ * RJK * RJ_K * R_KKK * (-1)
				+
				R * RJ * RJK * RJ_K * R_KKB * RJ_KBF * (-1)
				+
				R * RJ * RJK * RJ_K * R_KKB * RJ_KBC * (-2)
				+
				R * RJ * RJK * RJ_B * R_KBF * (1)
				+
				R * RJ * RJK * RJ_B * R_KBC * (-2)
				+
				R * RQ * RQJ * RQ_K * R_JKK * (1)
				+
				R * RQ * RQJ * RQ_K * R_JKB * RQ_KBF * (-1)
				+
				R * RQ * RQJ * RQ_K * R_JKB * RQ_KBC * (2)
				+
				R * RQ * RQJ * RQ_B * R_JBF * (1)
				+
				R * RQ * RQJ * RQ_B * R_JBC * (2)
				+
				R * RQ * RQK * RQ_K * R_KKK * (-1)
				+
				R * RQ * RQK * RQ_K * R_KKB * RQ_KBF * (-1)
				+
				R * RQ * RQK * RQ_K * R_KKB * RQ_KBC * (-2)
				+
				R * RQ * RQK * RQ_B * R_KBF * (1)
				+
				R * RQ * RQK * RQ_B * R_KBC * (-2)
				+
				R * RK * RKJ * RK_K * R_JKK * (1)
				+
				R * RK * RKJ * RK_K * R_JKB * RK_KBF * (-1)
				+
				R * RK * RKJ * RK_K * R_JKB * RK_KBC * (2)
				+
				R * RK * RKJ * RK_B * R_JBF * (1)
				+
				R * RK * RKJ * RK_B * R_JBC * (2)
				+
				R * RK * RKQ * RK_K * R_QKK * (1)
				+
				R * RK * RKQ * RK_K * R_QKB * RK_KBF * (-1)
				+
				R * RK * RKQ * RK_K * R_QKB * RK_KBC * (2)
				+
				R * RK * RKQ * RK_B * R_QBF * (1)
				+
				R * RK * RKQ * RK_B * R_QBC * (2)
				+
				0;

		// end auto-generated
		
		System.out.println("expected_payoff="+expected_payoff);
		System.out.println("-1/18="+(-1d/18));
		
	}
}
