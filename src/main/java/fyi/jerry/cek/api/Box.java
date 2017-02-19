package fyi.jerry.cek.api;

/** A Box.  Use it to substitute assignment for side-effect.
 *
 * @author jerry
 * @param <T>
 */
public interface Box<T> {
    public static <T> Box<T> create(T tt) {
        return new Box<T>() {
            private T t = tt;
            
            @Override
            public void set(T t) {
                this.t = t;
            }

            @Override
            public T get() {
                return t;
            }
        };
    }
    public void set(T t);
    public T get();
}
