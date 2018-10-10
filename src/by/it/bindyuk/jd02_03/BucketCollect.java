package by.it.bindyuk.jd02_03;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BucketCollect {

    private BlockingQueue<Bucket> collectBuckets = new ArrayBlockingQueue<>(50);

    {
        for (int i = 0; i < 50; i++) {
            Bucket bucket = new Bucket();
            collectBuckets.add(bucket);
        }
    }

    Bucket takeBucket() {
        try {
            return collectBuckets.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    void bucketReturn(Bucket bucket) {
        collectBuckets.add(bucket);
    }

    int sizeOfBuckets() {
        return collectBuckets.size();
    }

}
