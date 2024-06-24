package GUI;

public class Operator {
	Database db = null;
	joinScreen mf = null;
	loginScreen jf = null;
	Board bf = null;
	Write wf= null;
	MainScreen af = null;
	SearchScreen cf = null;
	MyPage pf = null;
	AdminMain df = null;
	AdminSeason as = null;
	SearchMap smf =null;
	
	public static void main(String[] args) {
		Operator opt = new Operator();
		opt.db = new Database();
		opt.jf = new loginScreen(opt);
		opt.mf = new joinScreen(opt);
		opt.bf = new Board(opt);
		opt.wf = new Write(opt);
		opt.af = new MainScreen(opt);
		opt.smf = new SearchMap(opt);
		opt.cf = new SearchScreen(opt);
		opt.pf = new MyPage(opt);
		opt.df = new AdminMain(opt);
		opt.as = new AdminSeason(opt);

		opt.jf.frame.setVisible(true);
	}
}