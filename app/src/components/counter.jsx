import React, { Component } from "react";

class Counter extends Component {
  render() {
    return (
      <div>
        <div className="row">
          <div className="">
            <span id={`item-counter-${this.props.counter.id}`} style={{ fontSize: 24 }} className={this.getBadgeClasses()}>
              {this.formatCount()}
            </span>
          </div>
          <div className="">
            <button
              id={`btn-plus-${this.props.counter.id}`}
              className="btn btn-secondary"
              onClick={() => this.props.onIncrement(this.props.counter)}
            >
              <i className="fa fa-plus-circle" aria-hidden="true" />
            </button>
            <button
              id={`btn-minus-${this.props.counter.id}`}
              className="btn btn-info m-2"
              onClick={() => this.props.onDecrement(this.props.counter)}
              disabled={this.props.counter.value === 0 ? "disabled" : ""}
            >
              <i className="fa fa-minus-circle" aria-hidden="true" />
            </button>
            <button
              id={`btn-trash-${this.props.counter.id}`}
              className="btn btn-danger"
              onClick={() => this.props.onDelete(this.props.counter.id)}
            >
              <i className="fa fa-trash-o" aria-hidden="true" />
            </button>
          </div>
        </div>
      </div>
    );
  }

  getBadgeClasses = () => {
    let classes = "badge m-2 badge-";
    classes += this.props.counter.value === 0 ? "warning" : "primary";
    return classes;
  };

  formatCount = () => {
    const { value } = this.props.counter;
    return value === 0 ? "Zero" : value;
  };
}

export default Counter;
