class Sleeper {
    public void wait(float seconds) {
        int milliseconds = (int) (seconds * 1000);
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }   
}