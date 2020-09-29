package com.hierarchy.family;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * @author sadasari
 * 
 *
 */

public class FamilyTree {

	public static void main(String[] args) {

		String familyInput = "\"null,0,grandpa|0,1,son|0,2,daugther|1,3,grandkid|1,4,grandkid|2,5,grandkid|5,6,greatgrandkid\"";

		String[] familyNodes = familyInput.split("\\|");

		List<Node<Data>> familyMembers = new ArrayList<Node<Data>>();

		for (String familyNode : familyNodes) {

			String[] nodes = familyNode.split(",");

			// We are dealing with fixed set of properties(3 fields) here, so no
			// issue with accessing by index

			Integer parentId = null;

			try {

				parentId = Integer.parseInt(nodes[0]);

			} catch (Exception e) {

				// ignore....

				System.out.println("Ignoring parseException");

			}

			Data data = new Data(parentId, Integer.valueOf(nodes[1]), nodes[2]);

			Node<Data> node = new Node<Data>(data);

			if (parentId == null) {

				node.setRoot(true);

			}

			familyMembers.add(node);

			// Form hierarchy now.

			for (int i = 0; i < familyMembers.size(); i++) {

				Node<Data> rootOrChild = familyMembers.get(i);

				if (rootOrChild.getData().getNodeId()
						.equals(node.getData().getParentId())) {

					// these are the children of the root(siblings to each
					// other.)

					rootOrChild.addChild(node);

				}

			}
			
		}

	
		printTree(familyMembers.get(0), " ");

	}

	private static Node<Data> createRelationshipNode(String relationshipName) {

		// create root node

		Node<Data> root = null;

		if (relationshipName.equals(RelationshipType.GRANDPA)) {

			Data rootData = new Data(null, 0,
					RelationshipType.GRANDPA.toString());

			root = new Node<>(rootData);

		} else if (relationshipName.equals(RelationshipType.SON)) {

			Data rootData = new Data(0, 1, RelationshipType.SON.toString());

			root = new Node<>(rootData);

		} else if (relationshipName.equals(RelationshipType.DAUGHTER)) {

			Data rootData = new Data(0, 2, RelationshipType.DAUGHTER.toString());

			root = new Node<>(rootData);

		} else if (relationshipName.equals(RelationshipType.GRAND_KID)) {

			Data rootData = new Data(null, 1,
					RelationshipType.GRAND_KID.toString());

			root = new Node<>(rootData);

		} else if (relationshipName.equals(RelationshipType.GREAT_GRAND_KID)) {

			Data rootData = new Data(null, 1,
					RelationshipType.GREAT_GRAND_KID.toString());

			root = new Node<>(rootData);

		}

		return root;

	}

	
	private static <T> void printTree(Node<T> node, String appendWith) {

		System.out.println(appendWith + node.getData());

		node.getChildren()
				.forEach(each -> printTree(each, appendWith + appendWith));

	}

}
