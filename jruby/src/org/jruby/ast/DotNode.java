/*
 * DotNode.java - description
 * Created on 01.03.2002, 15:42:44
 * 
 * Copyright (C) 2001, 2002 Jan Arne Petersen
 * Jan Arne Petersen <jpetersen@uni-bonn.de>
 *
 * JRuby - http://jruby.sourceforge.net
 * 
 * This file is part of JRuby
 * 
 * JRuby is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * JRuby is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JRuby; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 */
package org.jruby.ast;

import org.ablaf.ast.visitor.INodeVisitor;
import org.ablaf.ast.INode;
import org.ablaf.common.ISourcePosition;
import org.jruby.ast.visitor.NodeVisitor;

/** Represents a range literal.
 *
 * @author  jpetersen
 * @version $Revision$
 */
public class DotNode extends AbstractNode {
    static final long serialVersionUID = 2763797850980107429L;

    private final INode beginNode;
    private final INode endNode;
    private final boolean exclusive;

    public DotNode(ISourcePosition position, INode beginNode, INode endNode, boolean exclusive) {
        super(position);
        this.beginNode = beginNode;
        this.endNode = endNode;
        this.exclusive = exclusive;
    }

    /**
     * Accept for the visitor pattern.
     * @param iVisitor the visitor
     **/
    public void accept(INodeVisitor iVisitor) {
        ((NodeVisitor)iVisitor).visitDotNode(this);
    }

    /**
     * Gets the beginNode.
     * @return Returns a INode
     */
    public INode getBeginNode() {
        return beginNode;
    }

    /**
     * Gets the endNode.
     * @return Returns a INode
     */
    public INode getEndNode() {
        return endNode;
    }

    /**
     * Gets the exclusive.
     * @return Returns a boolean
     */
    public boolean isExclusive() {
        return exclusive;
    }
}
