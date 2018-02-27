package myduallinklist;

public class Test {

	public static void main(String[] args) {
		MyDualLinkList mLinkList = new MyDualLinkList();
		mLinkList.insertFirst(5);
		mLinkList.insertFirst(6);
		mLinkList.insertLast(4);
		mLinkList.displayDoubleLinkForward();
		//÷∏∂®≤Â»Î≤‚ ‘
		mLinkList.insert(10, 3);
		mLinkList.displayDoubleLinkForward();
		//…æ≥˝≤‚ ‘
		mLinkList.deleteFirst();
		mLinkList.displayDoubleLinkForward();
		//÷∏∂®…æ≥˝≤‚ ‘
		mLinkList.delete(2);
		mLinkList.displayDoubleLinkForward();

	}

}
