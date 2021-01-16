class Sleep {
    public void lp(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }   
}