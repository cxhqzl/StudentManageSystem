package main;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.button.ClassicButtonShaper;
import org.jvnet.substance.painter.StandardGradientPainter;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.skin.SubstanceCremeLookAndFeel;
import org.jvnet.substance.theme.SubstanceAquaTheme;
import org.jvnet.substance.watermark.SubstanceBubblesWatermark;

import panelPage.IndexPane;
import panelPage.InputInformation;
import panelPage.SelectInformation;
import panelPage.WelcomPane;
import paramer.AdminParamer;
/**
 * 学生管理系统主类
 * @author Xinhai Cao
 *
 */
public class MainClass extends JPanel implements TreeSelectionListener,PropertyChangeListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JEditorPane htmlPane;
    private JTree tree;
    private static boolean useSystemLookAndFeel = false;
    JScrollPane treeView;
    public static JFrame frame = new JFrame("学生信息管理系统");;
    /**管理员身份标志*/
    public boolean flag = false;
    JSplitPane splitPane;
    /**系统主页面*/
    public IndexPane ip = new IndexPane(this);
    /**信息录入页面*/
    public InputInformation inputInfo = new InputInformation();
    /**信息查询页面*/
    public SelectInformation selectInfo = new SelectInformation(this);
    /**登录成功界面*/
    WelcomPane wp = new WelcomPane();
    public MainClass() {
        super(new GridLayout(1,0));
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("学生信息管理");
        createNodes(top);

        tree = new JTree(top);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree.addTreeSelectionListener(this);
        treeView = new JScrollPane(tree);
        
        htmlPane = new JEditorPane();
        htmlPane.setEditable(false);
        JScrollPane htmlView = new JScrollPane(htmlPane);

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        if(flag) {
        	splitPane.setTopComponent(treeView);
        }
        if(flag) {
        	splitPane.setBottomComponent(wp);
        }else {
        	splitPane.setBottomComponent(ip);
        }

        Dimension minimumSize = new Dimension(100, 50);
        htmlView.setMinimumSize(minimumSize);
        treeView.setMinimumSize(minimumSize);
        splitPane.setDividerLocation(150); 
        splitPane.setPreferredSize(new Dimension(1200, 600));
        
        add(splitPane);
    }
    
    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category = null;
        DefaultMutableTreeNode book = null;

        category = new DefaultMutableTreeNode("信息录入");
        top.add(category);

        book = new DefaultMutableTreeNode("学生信息录入");
        category.add(book);


        category = new DefaultMutableTreeNode("信息查询");
        top.add(category);

        book = new DefaultMutableTreeNode("学生信息查询");
        category.add(book);

    }
        
    private static void createAndShowGUI() {
        if (useSystemLookAndFeel) {
            try {
                UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
        }
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MainClass());
        frame.pack();
        frame.setBounds(300, 200, 1200, 700);
        frame.setVisible(true);
    }
    
    public void valueChanged(TreeSelectionEvent e) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

        if (node == null)
        	return;

        Object nodeInfo = node.getUserObject();
        switch((String)nodeInfo) {
        case "学生信息录入":
        	splitPane.setBottomComponent(inputInfo);
        	break;
        case "学生信息查询":
        	splitPane.setBottomComponent(selectInfo);
        	break;
        }
    }


    public static void main(String[] args) {
    	try {
            UIManager.setLookAndFeel(new SubstanceCremeLookAndFeel());
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            SubstanceLookAndFeel.setCurrentTheme(new SubstanceAquaTheme());
            SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
            SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
            SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
            SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
            SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
        } catch (Exception e) {
            System.err.println("Something went wrong!");
        }
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    @Override
	public void propertyChange(PropertyChangeEvent e) {
    	AdminParamer ap = (AdminParamer) e.getNewValue();
    	switch(ap.btn) {
    	case "登录":
    		if(ap.username.equals("admin")&&ap.password.equals("admin")) {
    			flag = true;
    			splitPane.setTopComponent(treeView);
    			splitPane.setBottomComponent(wp);
    			splitPane.setDividerLocation(150); 
    		}else {
    			JOptionPane.showMessageDialog(this,"账号或密码不正确！");
    		}
    		break;
    	case "退出":
    		System.exit(0);
    		break;
    	}
	}

}
