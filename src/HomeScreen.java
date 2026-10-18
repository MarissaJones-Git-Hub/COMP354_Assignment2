
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class HomeScreen extends JFrame {
    private static final Color ORANGE = new Color(230, 81, 0);
    private static final Color DARK = new Color(28, 35, 43);

    public HomeScreen() {
        setTitle("QuickBite");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setLocationRelativeTo(null);

        BackgroundPanel background = new BackgroundPanel("assets/background.png");
        background.setLayout(new BorderLayout());
        setContentPane(background);

        background.add(createHeader(), BorderLayout.NORTH);
        background.add(createCenterPanel(), BorderLayout.CENTER);
        background.add(createFooter(), BorderLayout.SOUTH);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(230, 81, 0, 235));
        header.setBorder(new EmptyBorder(16, 30, 16, 30));

        JLabel brand = new JLabel("QuickBite");
        brand.setForeground(Color.WHITE);
        brand.setFont(new Font("SansSerif", Font.BOLD, 34));

        JLabel slogan = new JLabel("Fresh meals, fast pickup.");
        slogan.setForeground(Color.WHITE);
        slogan.setFont(new Font("SansSerif", Font.BOLD, 18));

        header.add(brand, BorderLayout.WEST);
        header.add(slogan, BorderLayout.EAST);
        return header;
    }

    private JPanel createCenterPanel() {
        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.setOpaque(false);

        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(new Color(255, 255, 255, 225));
        card.setBorder(new EmptyBorder(35, 55, 35, 55));

        JLabel title = new JLabel("QuickBite");
        title.setForeground(DARK);
        title.setFont(new Font("SansSerif", Font.BOLD, 54));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("Order from local restaurants and pick up your meal.");
        subtitle.setForeground(DARK);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 21));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton viewRestaurants = new JButton("View Restaurants  ->");
        viewRestaurants.setFont(new Font("SansSerif", Font.BOLD, 23));
        viewRestaurants.setForeground(Color.WHITE);
        viewRestaurants.setBackground(ORANGE);
        viewRestaurants.setFocusPainted(false);
        viewRestaurants.setBorder(new EmptyBorder(14, 30, 14, 30));
        viewRestaurants.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        viewRestaurants.setAlignmentX(Component.CENTER_ALIGNMENT);

        viewRestaurants.addActionListener(e -> {
            // Show restaurant displays
            JOptionPane.showMessageDialog(
                this,
                "Restaurant display will open here once the feature branches are integrated.",
                "QuickBite",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        card.add(title);
        card.add(Box.createVerticalStrut(12));
        card.add(subtitle);
        card.add(Box.createVerticalStrut(30));
        card.add(viewRestaurants);

        wrapper.add(card);
        return wrapper;
    }

    private JPanel createFooter() {
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(28, 35, 43, 235));
        footer.setBorder(new EmptyBorder(12, 25, 12, 25));

        JLabel left = new JLabel("QuickBite | Food Ordering App");
        left.setForeground(Color.WHITE);

        JLabel right = new JLabel("COMP 354 - Group 10");
        right.setForeground(Color.WHITE);

        footer.add(left, BorderLayout.WEST);
        footer.add(right, BorderLayout.EAST);
        return footer;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HomeScreen().setVisible(true));
    }

    static class BackgroundPanel extends JPanel {
        private final Image backgroundImage;

        BackgroundPanel(String imagePath) {
            backgroundImage = new ImageIcon(imagePath).getImage();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int panelW = getWidth();
            int panelH = getHeight();
            int imgW = backgroundImage.getWidth(this);
            int imgH = backgroundImage.getHeight(this);

            if (imgW <= 0 || imgH <= 0) return;

            double scale = Math.max((double) panelW / imgW, (double) panelH / imgH);
            int drawW = (int) (imgW * scale);
            int drawH = (int) (imgH * scale);

            int x = (panelW - drawW) / 2;
            int y = (panelH - drawH) / 2;

            g.drawImage(backgroundImage, x, y, drawW, drawH, this);
        }
    }
}
