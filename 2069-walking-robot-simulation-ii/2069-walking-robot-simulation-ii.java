class Robot {

    int n, width, height, currIndex;
    int[][] pos;
    boolean moved = false;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        n = (width + height) * 2 - 4;
        currIndex = 0;
        pos = new int[n][2];
        int index = 0;
        for (int i = 0; i < width; i++) {
            pos[index][0] = i;
            index++;
        }
        for (int i = 1; i < height; i++) {
            pos[index][1] = i;
            pos[index][0] = width - 1;
            index++;
        }
        for (int i = width - 2; i >= 0; i--) {
            pos[index][1] = height - 1;
            pos[index][0] = i;
            index++;
        }
        for (int i = height - 2; i > 0; i--) {
            pos[index][1] = i;
            index++;
        }
    }

    public void step(int num) {
        moved = true;
        currIndex = (currIndex + num) % n;
    }

    public int[] getPos() {
        return pos[currIndex];
    }

    public String getDir() {
        if (!moved || (currIndex > 0 && currIndex < width)) {
            return "East";
        }
        if (currIndex >= width && currIndex < width + height - 1) {
            return "North";
        }
        if (currIndex >= width + height - 1 && currIndex < 2 * width + height - 2) {
            return "West";
        }
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */