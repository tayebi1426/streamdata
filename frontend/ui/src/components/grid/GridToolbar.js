import React from "react";
import {GridContext} from './GridContext';

function GridToolbar(props) {

    return (
        <GridContext.Consumer>
            {({selectedItems}) => {
                let children = React.Children.toArray(props.children).map(child => {
                    return React.cloneElement(child, {
                        onClick: (e) => child.props.onClick(e, selectedItems)
                    });
                });

                return (
                    <div className={"data-grid-toolbar"}>
                        {children}
                    </div>
                )
            }}
        </GridContext.Consumer>
    );

}

export default GridToolbar;