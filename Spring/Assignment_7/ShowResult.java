import java.awt.*;
import java.util.*;

public class ShowResult extends Frame {

    public class ImagePanel extends Panel {
        private ArrayList<String[]> data;
        private static final int SCALE_FACTOR = 80; // 放大倍數
        private HashMap<String, Integer> colorMap = new HashMap<>();

        public ImagePanel(ArrayList<String[]> data) {
            this.data = data;
            colorMap.put("H7", 0xFF0000);
            colorMap.put("O6", 0xDBFF2F);
            colorMap.put("F5", 0xEE82EE);
            colorMap.put("Y5", 0x00FF00);
            colorMap.put("V5", 0xFFC0CB);
            colorMap.put("U5", 0x0000FF);
            colorMap.put("N5", 0xFF8C00);
            colorMap.put("L5", 0x008000);
            colorMap.put("Z5", 0xFFFF00);
            colorMap.put("O4", 0xFFD700);
            colorMap.put("T4", 0x800080);
            colorMap.put("Z4", 0x00FFFF);
            colorMap.put("L4", 0x00BFFF);
            // colorMap.put("1", 0xFFFFFF);
        }

        @Override
        public void paint(Graphics g) {
            int width = data.get(0).length;
            int height = data.size();

            // 根據資料設定每個像素的顏色
            for(int y = 0; y < height; y++) {
                String[] row = data.get(y);
                for(int x = 0; x < width; x++) {
                    int colorValue = row[x].equals("0") ? 0x000000 : colorMap.get(row[x]); //黑色:彩色
                    g.setColor(new Color(colorValue));

                    // 將每個像素放大 SCALE_FACTOR 倍
                    int scaledX = x * SCALE_FACTOR;
                    int scaledY = y * SCALE_FACTOR;
                    g.fillRect(scaledX, scaledY, SCALE_FACTOR, SCALE_FACTOR); // 繪製方塊
                }
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(data.get(0).length * SCALE_FACTOR, data.size() * SCALE_FACTOR);
        }
    }


    public ShowResult(ArrayList<String[]> data) {
        setTitle("Image Display");
        setSize(800, 600);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        Panel panel = new ImagePanel(data);
        add(panel);

        setVisible(true);
    }
}
